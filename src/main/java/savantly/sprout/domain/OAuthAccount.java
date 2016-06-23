package savantly.sprout.domain;

public class OAuthAccount {

	private String provider;
	private Object token;
	
	public OAuthAccount(){}
	
	public OAuthAccount(String provider, Object token) {
		this.provider = provider;
		this.token = token;
	}
	
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Object getToken() {
		return token;
	}
	public void setToken(Object token) {
		this.token = token;
	}
}
