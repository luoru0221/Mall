package lrmall.dao;

import lrmall.bean.Evaluate;

import java.util.ArrayList;

public interface EvaluateDao {

    /**
     * @time 2019年10月10日15:40:34
     * @param pid 商品id
     * @return 该商品的所有评价
     */
    ArrayList<Evaluate> selectEvaluatesByPid(int pid);

    int addEvaluateForProduct(Evaluate evaluate);

}
