package mvcmem.control;

public class ActionForward {
	private String url;
	private Boolean redirect;
	
	public ActionForward(String url, boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}
	
}
