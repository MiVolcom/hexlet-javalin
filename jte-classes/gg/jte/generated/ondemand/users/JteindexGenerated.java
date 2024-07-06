package gg.jte.generated.ondemand.users;
import org.example.hexlet.dto.UsersPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "users/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,10,10,10,13,13,13,16,16,16,16,16,16,19,19,22,22,22,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UsersPage page) {
		jteOutput.writeContent("\r\n    <h1>Users</h1>\r\n\r\n    <div class=\"mb-3\">\r\n        <a href=\"/users/build\">Sign up a new user</a>\r\n    </div>\r\n\r\n    <table class=\"table table-striped\">\r\n        ");
		for (var user : page.getUsers()) {
			jteOutput.writeContent("\r\n            <tr>\r\n                <td>\r\n                    ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getId());
			jteOutput.writeContent("\r\n                </td>\r\n                <td>\r\n                    ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getFirstName());
			jteOutput.writeContent(" ");
			jteOutput.setContext("td", null);
			jteOutput.writeUserContent(user.getLastName());
			jteOutput.writeContent("\r\n                </td>\r\n            </tr>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </table>\r\n\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UsersPage page = (UsersPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
