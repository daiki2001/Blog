import './Notfound.css'
import React from 'react';

function Notfound() {
    return (
        <div className='Notfound'>
            <h1>指定のページが見つかりません</h1>
            <p>申し訳ございませんが、検索中のページは存在しないか、<br />
                名前変更のため一時的にご利用が不可能です。</p>
            <p>お手数をおかけしますが、<br />
                上部のメニューよりおさがしいただきますようにお願いいたします。</p>
        </div>
    )
}

export default Notfound;