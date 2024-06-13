import './App.css';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import Home from './Home';
import AllBlog from './AllBlog';
import Blog from './Blog';

function App() {
    // ヘッダー
    const Header = () => {
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

    return (
        <Router>
            <div className="App">
                {Header()}
                {/* 各ページへのルート設定 */}
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/Blog" element={<AllBlog />} />
                </Routes>
                {/* <Blog blog={1} /> */}
            </div>
        </Router>
    );
}

export default App;
