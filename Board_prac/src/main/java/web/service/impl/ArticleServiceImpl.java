package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.ArticleDao;
import web.dto.Article;
import web.service.face.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired ArticleDao articleDao;

	@Override
	public void create(Article article) {
		articleDao.create(article);
	}

	@Override
	public Article read(int articleNo) {
		return articleDao.read(articleNo);
	}

	@Override
	public void update(Article article) {
		articleDao.update(article);
	}

	@Override
	public void delete(int articleNo) {
		articleDao.delete(articleNo);
	}

	@Override
	public List<Article> listAll() {
		return articleDao.listAll();
	}

}
