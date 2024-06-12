import React, { useState, useEffect } from 'react';
import './Comment.css'

function Comment(props) {
    let path = 'http://localhost:8080/blog/comment/';
    let [data, setData] = useState([]);
    console.log(props.blog);

    useEffect(() => {
        console.log("call useEffect START");
        path = 'http://localhost:8080/blog/comment/' + props.blog.id;
        console.log("PATH: " + path);
        fetch(path).then(res => {
            if (!res.ok) {
                throw new Error('Network response was not ok');
            }
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
    }, [props.blog.id]);

    // コメント情報を再取得する関数
    const fetchCommentData = () => {
        path = 'http://localhost:8080/blog/comment/' + props.blog.id;
        fetch(path)
            .then(res => res.json())
            .then(data => {
                setData(data);
            })
            .catch(error => {
                console.error('Error fetching blog data:', error);
                setData([]);
            });
    }

    // コメント情報を追加する関数
    const addData = (formData) => {
        console.log(formData);
        fetch('http://localhost:8080/blog/comment/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(res => {
                if (res.ok) {
                    // コメント情報が正常に追加された場合、コメント情報を再取得して更新する
                    return fetchCommentData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to add data');
                }
            })
            .catch(error => {
                console.error('Error adding data:', error);
            });
    }

    // コメント情報を更新する関数
    const updateData = (formData) => {
        console.log(formData);
        formData.article += "abc"
        fetch('http://localhost:8080/blog/comment/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(res => {
                if (res.ok) {
                    // コメント情報が正常に更新された場合、コメント情報を再取得して更新する
                    return fetchCommentData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to update data');
                }
            })
            .catch(error => {
                console.error('Error updating data:', error);
            });
    }

    // コメント情報を削除する関数
    const deleteData = (formData) => {
        console.log(formData);
        fetch('http://localhost:8080/blog/comment/delete', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
            .then(res => {
                if (res.ok) {
                    // コメント情報が正常に削除された場合、コメント情報を再取得して更新する
                    return fetchCommentData();
                } else {
                    // エラーメッセージを表示するなどの処理を行う
                    console.error('Failed to delete data');
                }
            })
            .catch(error => {
                console.error('Error deleting data:', error);
            });
    }

    // フォームから送信された際の処理
    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        const newData = {
            blog: {
                id: parseInt(props.blog.id),
                title: props.blog.title,
                article: props.blog.article,
                postTime: props.blog.postTime,
                updateTime: props.blog.updateData
            },
            name: formData.get('name'),
            article: formData.get('article')
        };
        addData(newData);
    }

    return (
        <div id='Comment'>
            <h3>コメント欄</h3>
            <h4>コメントの追加</h4>
            <form onSubmit={handleSubmit}>
                <input type="number" name="blog" value={props.blog.id} hidden required disabled />
                <label>
                    名前:
                    <input type="text" name="name" required />
                </label>
                <label>
                    コメント:
                    <textarea name="article" required />
                </label>
                <button type="submit">追加</button>
            </form>
            {data.map((item, index) => (
                <div key={index} id='Comment_line'>
                    <h4>{item.id}:{item.name}</h4>
                    <p>{item.article}</p>
                    <button type='submit' onClick={() => updateData(item)}>編集</button>
                    <button type='submit' onClick={() => deleteData(item)}>削除</button>
                </div>
            ))}
        </div>
    );
}

export default Comment