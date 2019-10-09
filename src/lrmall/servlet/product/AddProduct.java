package lrmall.servlet.product;

import com.alibaba.fastjson.JSONArray;
import lrmall.bean.Product;
import lrmall.dao.impl.ProductDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        upLoadImg(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        addProduct(req, resp);
    }

    /**
     * 保存基本信息以及分类信息到数据库
     */
    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        String pName = req.getParameter("pName");   //商品名字
        String pDescription = req.getParameter("pDescription"); //商品描述
        double pPrice = Double.parseDouble(req.getParameter("pPrice")); //商品价格
        int pType = Integer.parseInt(req.getParameter("pType"));    //商品分类
        String pImage = req.getParameter("pImage");

        String tips = req.getParameter("tips");     //商品规格的json字符串
        JSONArray jsonArray = JSONArray.parseArray(tips);
        ArrayList<ArrayList<String>> tipsList = new ArrayList<>();  //商品规格
        for (Object itemObj : jsonArray) {
            String itemStr = JSONArray.toJSONString(itemObj);
            JSONArray itemArray = JSONArray.parseArray(itemStr);
            ArrayList<String> listItem = new ArrayList<>();
            for (Object item : itemArray) {
                listItem.add((String) item);
            }
            tipsList.add(listItem);
        }
        Product product = new Product();
        product.setName(pName);
        product.setDescription(pDescription);
        product.setPrice(pPrice);
        product.setImage(pImage);
        product.setType(pType);

        saveData(product, tipsList);
    }

    /**
     * 上传图片
     */
    private void upLoadImg(HttpServletRequest req, HttpServletResponse resp) {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List items = null;
        FileItem item;
        //解析请求信息
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        assert items != null;
        for (Object obj : items) {
            item = (FileItem) obj;
            if (!item.isFormField()) {
                String fileName = item.getName();
                int index = fileName.lastIndexOf(".");
                //图片名称使用当前时间戳命名，保证名称唯一性
                fileName = System.currentTimeMillis() + fileName.substring(index);
                req.setAttribute("realFileName", fileName);
                File baseDir = new File("D:\\MyProject\\Mall\\web\\images\\goods");
                File targetFile = new File(baseDir, fileName);
                fileName = "images\\goods\\"+fileName;
                try {
                    if (!targetFile.exists()) {
                        boolean newFile = targetFile.createNewFile();
                        if (!newFile) {
                            System.out.println("文件创建失败！！！");
                        }
                        item.write(targetFile);
                    }
                    PrintWriter writer = resp.getWriter();
                    writer.print(fileName);//将目标文件地址输出
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将数据保存到数据库
     */
    private void saveData(Product product, ArrayList<ArrayList<String>> list) {

        ProductDaoImpl productDao = new ProductDaoImpl();
        int num = productDao.addProduct(product);
        if (num > 0) {
            for (ArrayList<String> strings : list) {
                String tipName = strings.get(0);
                String tip;
                for(int i =1;i< strings.size();i++){
                    tip = strings.get(i);
                    productDao.addTips(tipName,tip);
                }
            }
        }
    }
}


