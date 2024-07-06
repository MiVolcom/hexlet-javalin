    <form action="/users" method="post">
        <div class="mb-3">
            <label class="form-label">
                Name
                <input type="text" class="form-control" name="firstName" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Last Name
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
                Password
                <input type="password" class="form-control" required name="password" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Sign up" />
    </form>
