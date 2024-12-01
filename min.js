
const userForm = document.getElementById('userForm');
const userTable = document.getElementById('userTable');
let userCount = 0;

// Form Validation and Add User
userForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const userName = document.getElementById('userName').value.trim();
    const userEmail = document.getElementById('userEmail').value.trim();
    const userRole = document.getElementById('userRole').value;

    let isValid = true;

    // Clear previous errors
    document.getElementById('nameError').innerText = '';
    document.getElementById('emailError').innerText = '';
    document.getElementById('roleError').innerText = '';

    // Validate Name
    if (userName === '') {
        document.getElementById('nameError').innerText = 'Name is required.';
        isValid = false;
    }

    // Validate Email
    if (userEmail === '') {
        document.getElementById('emailError').innerText = 'Email is required.';
        isValid = false;
    } else if (!/\S+@\S+\.\S+/.test(userEmail)) {
        document.getElementById('emailError').innerText = 'Invalid email format.';
        isValid = false;
    }

    // Validate Role
    if (userRole === '') {
        document.getElementById('roleError').innerText = 'Role is required.';
        isValid = false;
    }

    if (isValid) {
        userCount++;
        const newRow = `
            <tr>
                <td>${userCount}</td>
                <td>${userName}</td>
                <td>${userEmail}</td>
                <td>${userRole}</td>
                <td>
                    <button class="btn btn-sm btn-warning">Edit</button>
                    <button class="btn btn-sm btn-danger">Delete</button>
                </td>
            </tr>
        `;
        userTable.innerHTML += newRow;

        // Reset Form and Close Modal
        userForm.reset();
        const modal = bootstrap.Modal.getInstance(document.getElementById('addUserModal'));
        modal.hide();
    }
});
