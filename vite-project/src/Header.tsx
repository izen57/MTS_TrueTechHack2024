import './Header.css';

function Header() {
	return (
		<header className="header">
			<img src="/public/vite.svg" alt="МТС лого" className="logo" />
			<nav className="nav_container">
				<ul className="nav_list">
					<li><a href="/">Аккаунт</a></li>
					<li><a href="/about">Бизнес</a></li>
					<li><a href="/services">Мои документы</a></li>
					<li><a href="/contact">Поддержка</a></li>
				</ul>
				{/* <Search/> */}
				{/* <Notifications/> */}
				{/* <Menu/> */}
				{/* <Account/> */}
			</nav>
		</header>
	);
}

export default Header;