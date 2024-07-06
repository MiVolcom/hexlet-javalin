@import org.example.hexlet.dto.UsersPage
@param UsersPage page

    <h1>Users</h1>

    <div class="mb-3">
        <a href="/users/build">Sign up a new user</a>
    </div>

    <table class="table table-striped">
        @for(var user : page.getUsers())
            <tr>
                <td>
                    ${user.getId()}
                </td>
                <td>
                    ${user.getFirstName()} ${user.getLastName()}
                </td>
            </tr>
        @endfor
    </table>

