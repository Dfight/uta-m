package com.macross.dao;

import com.macross.entry.card;
import com.macross.entry.card_detailed;
import com.macross.entry.card_singer;
import com.macross.entry.singer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface cardDao {
    public card getCard_url(String url);
    public int addCard(card card);
    public int addCard_Singer(card_singer card_singer);
    public int addCard_detailed(card_detailed card_detailed);
    public List<card> getAllCard();
    public HashMap<String,Object> getCard_id(int id);
    public card_detailed getCardInit(int id);
    public card_detailed getCardMax(int id);
    public List<singer> getCardSinger(int id);
    public List<HashMap<String,Object>> getCardList(@Param("star") Integer[] star,
                                                    @Param("opus") Integer[] opus,
                                                    @Param("attr") Integer[] attr,
                                                    @Param("singer") Integer[] singer,
                                                    @Param("start") Integer start,
                                                    @Param("center") String center,
                                                    @Param("action") String action,
                                                    @Param("live") String live);
}
