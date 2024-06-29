@import org.example.hexlet.dto.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <h1>Пользователи</h1>
    <table class="table table-striped">
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                </td>
            </tr>
        @endfor
    </table>
`,
footer = @`
    <a href="https://github.com/MiVolcom">MiVolcom</a>
`
)