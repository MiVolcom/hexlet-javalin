@import org.example.hexlet.dto.UserPage
@param UserPage page

@template.layout.page(

content = @`
    <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
    <div>${page.getUser().getEmail()}</div>
    <div>Unescaped User ID: ${page.getUserId()}</div>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)