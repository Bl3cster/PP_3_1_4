const getRolesList = "http://localhost:8080/api/roles"

async function findRolesList() {
    // Получаем список всех ролей и возвращаем его
    return await fetch(getRolesList).then(response => response.json());
}