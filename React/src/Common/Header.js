import React from 'react';
import { Link } from 'react-router-dom';
import './Header.css'

function Header() {
    return (
        <header>
            <h1>自由気ままにエンジニアリング</h1>
            {/* ナビゲーションバー */}
            <nav>
                <ul>
                    <li><Link to="/">ホーム</Link></li>
                    <li><Link to="/Blog">ブログトップ</Link></li>
                </ul>
            </nav>
        </header>
    )
}

export default Header;
