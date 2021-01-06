package travel.dao;

import travel.domain.Favorite;

public interface FavoriteDao {
    /**
     * 根据rid和uid查询收藏信息
     * */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询收藏
     * */
    public int findCountByRid(int rid);

    /**
     * 添加收藏方法
     * */
    void add(int rid, int uid);
}
