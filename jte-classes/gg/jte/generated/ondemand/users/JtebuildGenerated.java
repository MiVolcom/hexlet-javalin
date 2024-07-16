package gg.jte.generated.ondemand.users;
import org.example.hexlet.model.BuildUserPage;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,3,3,5,5,7,7,9,9,10,10,11,11,11,12,12,13,13,15,15,49,49,49,49,49,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, BuildUserPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n\r\n");
				if (page.getErrors() != null) {
					jteOutput.writeContent("\r\n    <ul>\r\n        ");
					for (var validator : page.getErrors().values()) {
						jteOutput.writeContent("\r\n            ");
						for (var error : validator) {
							jteOutput.writeContent("\r\n                <li>");
							jteOutput.setContext("li", null);
							jteOutput.writeUserContent(error.getMessage());
							jteOutput.writeContent("</li>\r\n            ");
						}
						jteOutput.writeContent("\r\n        ");
					}
					jteOutput.writeContent("\r\n    </ul>\r\n");
				}
				jteOutput.writeContent("\r\n    <form action=\"/users\" method=\"post\">\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Имя\r\n                <input type=\"text\" class=\"form-control\" name=\"firstName\" />\r\n            </label>\r\n        </div>\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Фамилия\r\n                <input type=\"text\" class=\"form-control\" name=\"lastName\" />\r\n            </label>\r\n        </div>\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Email\r\n                <input type=\"email\" class=\"form-control\" required name=\"email\" />\r\n            </label>\r\n        </div>\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Пароль\r\n                <input type=\"password\" class=\"form-control\" required name=\"password\" />\r\n            </label>\r\n        </div>\r\n        <div class=\"mb-3\">\r\n            <label class=\"form-label\">\r\n                Подтверждение пароля\r\n                <input type=\"password\" class=\"form-control\" required name=\"passwordConfirmation\" />\r\n            </label>\r\n        </div>\r\n        <input type=\"submit\" class=\"btn btn-primary\" value=\"Зарегистрировать\" />\r\n    </form>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		BuildUserPage page = (BuildUserPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
