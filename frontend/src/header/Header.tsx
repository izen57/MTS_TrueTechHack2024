import Account from '../acc_ctrl/Account';
import Menu from '../acc_ctrl/Menu';
import Notifications from '../acc_ctrl/Notifications';
import Search from '../acc_ctrl/Search';
import './Header.css';

function Header() {
	return (
		<header className="header">
			<img src="./src/assets/Logo_mts.svg" alt="МТС лого" className="logo" />
			<nav className="nav_container">
				<ul className="nav_list">
					<li><a href="/">Аккаунт</a></li>
					<li><a href="/about">Бизнес</a></li>
					<li><a href="/services">Мои документы</a></li>
					<li><a href="/contact">Поддержка</a></li>
				</ul>
			</nav>
			<div className='acc_ctrl'>
					<Search/>
					<Notifications/>
					<Menu/>
					<Account/>
				</div>
		</header>
	);
}

export default Header;