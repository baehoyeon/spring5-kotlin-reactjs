import React from 'react';

require('!style!css!less!./MessageBox.less');


export class MessageBox extends React.Component {
    render() {
        return (
            <div className="app-message">
                ReactJs is powerful library
            </div>
        );
    }
}
