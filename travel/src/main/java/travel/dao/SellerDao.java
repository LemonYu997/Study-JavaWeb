package travel.dao;

import travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据id查询商家
     * */
    public Seller findById(int sid);
}
