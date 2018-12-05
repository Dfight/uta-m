package com.macross.service;

import com.macross.entry.card;
import com.macross.entry.card_detailed;
import com.macross.entry.card_singer;

import java.util.List;

public interface cardService {
    public card getCard_url(String url);
    public int addCard(card card);
    public int addCard_Singer(card_singer card_singer);
    public int addCard_detailed(card_detailed card_detailed);
    public List<card> getAllCard();
}
