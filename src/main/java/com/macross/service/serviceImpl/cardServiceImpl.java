package com.macross.service.serviceImpl;

import com.macross.dao.cardDao;
import com.macross.entry.card;
import com.macross.entry.card_detailed;
import com.macross.entry.card_singer;
import com.macross.service.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cardService")
public class cardServiceImpl implements cardService {
    @Autowired
    public cardDao cardDao;
    @Override
    public card getCard_url(String url) {
        return cardDao.getCard_url(url);
    }

    @Override
    public int addCard(card card) {
        return cardDao.addCard(card);
    }

    @Override
    public int addCard_Singer(card_singer card_singer) {
        return cardDao.addCard_Singer(card_singer);
    }

    @Override
    public int addCard_detailed(card_detailed card_detailed) {
        return cardDao.addCard_detailed(card_detailed);
    }

    @Override
    public List<card> getAllCard() {
        return cardDao.getAllCard();
    }
}
