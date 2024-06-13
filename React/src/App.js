import './App.css';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';

// ページの共通部分
import Header from './Common/Header';
import Footer from './Common/Footer';

// 各ページのページコンポーネント
import Home from './Home';
import AllBlog from './AllBlog';
import Blog from './Blog';
import Notfound from './Notfound';

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                {/* 各ページへのルート設定 */}
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/Blog" element={<AllBlog />} />
                    <Route path="*" element={<Notfound />} />
                </Routes>
                {/* <Blog blog={1} /> */}
                <Footer />
            </div>
        </Router>
    );
}

export default App;
