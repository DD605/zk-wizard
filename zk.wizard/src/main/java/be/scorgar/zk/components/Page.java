package be.scorgar.zk.components;


public class Page {
	
	public static final String PREFIX = "/WEB-INF/pages/";
	public static final String SURFIX = ".zul";
	
	private String page;

	private Page() {}
	
	public static Page uri(String page) {
		Page pages = new Page();
		pages.page = page;
		return pages;
	}
	
	public String getPage() {
		return new StringBuilder(PREFIX).append(page).append(SURFIX).toString().replace("//","/");
	}
}
