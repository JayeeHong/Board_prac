package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import web.dto.Article;
import web.service.face.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired ArticleService articleService;
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	// 게시글 추가 페이지 이동
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeGET() {
		
		logger.info("write GET...");
		
		return "/article/write";
	}
	
	// 게시글 추가 처리
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePOST(Article article, RedirectAttributes redirectAttributes) {
		
		logger.info("write POST...");
		logger.info(article.toString());
		
		articleService.create(article);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		
		return "redirect:/article/list";
	}
	
	// 목록 페이지 이동
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		logger.info("list...");
		
		model.addAttribute("articles", articleService.listAll());
		
		return "/article/list";
	}
	
	// 조회 페이지 이동
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo, Model model) {
		
		logger.info("read...");
		
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/read";
	}
	
	// 수정 페이지 이동
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo, Model model) {
		
		logger.info("modifyGet...");
		
		model.addAttribute("article", articleService.read(articleNo));
		
		return "/article/modify";
	}
	
	// 수정 처리
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(Article article, RedirectAttributes redirectAttributes) {
		
		logger.info("modifyPOST...");
		
		articleService.update(article);
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		
		return "redirect:/article/list";
	}
	
	// 삭제 처리
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("articleNo") int articleNo, RedirectAttributes redirectAttributes) {
		
		logger.info("remove...");
		
		articleService.delete(articleNo);
		redirectAttributes.addFlashAttribute("msg", "delSuccess");

		return "redirect:/article/list";
	}

}
