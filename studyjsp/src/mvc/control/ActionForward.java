package mvc.control;

public class ActionForward {
	private String url; // 가야할 페이지 명
	private Boolean redirect; // true=redirect, false=forward
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getRedirect() {
		return redirect;
	}
	public void setRedirect(Boolean redirect) {
		this.redirect = redirect;
	}
	
	
}
