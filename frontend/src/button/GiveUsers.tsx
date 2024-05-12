import { BackendResponse, call } from "./Button";

function GiveUsers() {
	return (
		alert(call<BackendResponse[]>('http://localhost:8080/users/user1'))
	)
}

export default GiveUsers;