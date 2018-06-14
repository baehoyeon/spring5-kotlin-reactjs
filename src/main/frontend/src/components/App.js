require('normalize.css/normalize.css');
require('styles/App.css');

import React from 'react';

class App extends React.Component {
  render() {
    return (
      <div className="index">
        <div className="notice">Please edit <code>src/components/Main.js</code> to get started!</div>
      </div>
    );
  }
}

export default App;
