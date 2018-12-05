package com.macross.dao;

import com.macross.entry.card;
import com.macross.entry.card_detailed;
import com.macross.entry.card_singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cardDao {
    public card getCard_url(String url);
    public int addCard(card card);
    public int addCard_Singer(card_singer card_singer);
    public int addCard_detailed(card_detailed card_detailed);
    public List<card> getAllCard();
}
