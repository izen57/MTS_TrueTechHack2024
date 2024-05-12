import './App.css'
import Header from './header/Header'
import Button from './button/Button'
import DialogDisabled from './button/DialogDisabled'

function App() {
	return (
		<>
			<Header/>
			<Button onClick={DialogDisabled}>Версия для слабовидящих</Button>
		</>
	)
}

export default App
