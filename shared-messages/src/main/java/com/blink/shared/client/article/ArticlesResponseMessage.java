package com.blink.shared.client.article;

import com.blink.shared.common.Article;
import com.blink.utilities.BlinkJSON;

import java.util.List;

public class ArticlesResponseMessage {
	private List<Article> articles;

	public ArticlesResponseMessage() {}

	public ArticlesResponseMessage(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public ArticlesResponseMessage setArticles(List<Article> articles) {
		this.articles = articles;
		return this;
	}

	@Override
	public String toString() {
		return BlinkJSON.toPrettyJSON(this);
	}
}