package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,30,30,30,30,33,33,36,36,36,39,39,42,42,42,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hexlet Javalin Example</title>\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\r\n          rel=\"stylesheet\"\r\n          integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\r\n          crossorigin=\"anonymous\">\r\n</head>\r\n<body>\r\n<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n    <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n        <ul class=\"navbar-nav\">\r\n            <li class=\"nav-item active\">\r\n                <a class=\"nav-link\" href=\"/\">Home</a>\r\n            </li>\r\n            <li class=\"nav-item\">\r\n                <a class=\"nav-link\" href=\"/users\">Users</a>\r\n            </li>\r\n        </ul>\r\n    </div>\r\n</nav>\r\n\r\n<div class=\"mx-auto p-4 py-md-5\">\r\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n</div>\r\n\r\n");
		if (footer != null) {
			jteOutput.writeContent("\r\n    <footer class=\"text-center text-lg-start bg-light text-muted\">\r\n        <div class=\"text-center p-4\" style=\"background-color: rgba(0, 0, 0, 0.05);\">\r\n            ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(footer);
			jteOutput.writeContent("\r\n        </div>\r\n    </footer>\r\n");
		}
		jteOutput.writeContent("\r\n\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		render(jteOutput, jteHtmlInterceptor, content, footer);
	}
}
