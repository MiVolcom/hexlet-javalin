@import org.example.hexlet.model.BuildUserPage
@param BuildUserPage page

@template.layout.page(
content = @`

@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif
    <form action="/users" method="post">
        <div class="mb-3">
            <label class="form-label">
                Имя
                <input type="text" class="form-control" name="firstName" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Фамилия
                <input type="text" class="form-control" name="lastName" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Email
                <input type="email" class="form-control" required name="email" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Пароль
                <input type="password" class="form-control" required name="password" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Подтверждение пароля
                <input type="password" class="form-control" required name="passwordConfirmation" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Зарегистрировать" />
    </form>
`
)