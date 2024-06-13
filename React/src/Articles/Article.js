import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';
import Comment from './Comment';
import './Article.css';

function Article() {
    const { id } = useParams();
    let [data, setData] = useState([]);

    useEffect(() => {
        console.log("call useEffect START");
        const path = `http://localhost:8080/blog/${id}`;
        console.log(`PATH: ${path}`);
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

    return (
        <div className='Blog'>
            <div className='Blog_line'>
                <h2>{data.title}</h2>
                <p>{data.article}</p>
            </div>
            <Comment blog={data} />
        </div>
    )
}

export default Article