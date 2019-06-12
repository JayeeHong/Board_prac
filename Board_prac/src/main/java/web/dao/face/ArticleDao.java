package web.dao.face;

import java.util.List;

import web.dto.Article;

public interface ArticleDao {
	
	// 글쓰기
	public void create(Article article);
	
	// 해당 게시글 조회
	public Article read(int acticleNo);
	
	// 게시글 수정
	public void update(Article article);
	
	// 게시글 삭제
	public void delete(int articleNo);
	
	// 게시글 전체 조회
	public List<Article> listAll();

}
