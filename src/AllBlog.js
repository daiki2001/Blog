import React, { useState, useEffect } from 'react';
import './Blog.css';

function AllBlog() {
    let [data, setData] = useState([]);

    useEffect(() => {
        console.log("call useEffect START");
        const path = 'http://localhost:8080/'
        console.log("PATH: " + path);
        fetch(path).then(res => {
            res.json().then(value => {
                console.log(value);
                setData(value);
            })
        }).catch(error => {
            console.log(error);
            setData([]);
        });

        console.log("call useEffect END");
        return () => { };
    }, []);

    // 記事情報を再取得する関数
    const fetchBlogData = () => {
        fetch('http://localhost:8080/')
            .then(res => res.json())
            .then(data => {
                setData(data);
            })
            .catch(error => {
                console.error('Error fetching blog data:', error);
                setData([]);
            });
    }

    // 記事情報を追加する関数
    const addData = (formData) => {
        console.log(formData);
        fetch('http://localhost:8080/blog/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(res => {
                if (res.ok) {
                    // 在庫情報が正常に追加された場合、フルーツデータを再取得して更新する
                    return fetchBlogData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to add data');
                }
            })
            .catch(error => {
                console.error('Error adding data:', error);
            });
    }

    // フォームから送信された際の処理
    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        const newData = {
            title: formData.get('title'),
            article: formData.get('article')
        };
        console.log(newData);
        addData(newData);
    }

    return (
        <div id='Blog'>
            <h2>全記事</h2>
            {data.map((item, index) => (
                <div key={index} id='Blog_line'>
                    <h3>{item.title}</h3>
                    <p>{item.article}</p>
                </div>
            ))}
            <h2>記事の追加</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    記事名:
                    <input type="text" name="title" required />
                </label>
                <label>
                    本文:
                    <textarea name="article" required />
                </label>
                <button type="submit">追加</button>
            </form>
        </div>
    );
}

export default AllBlog