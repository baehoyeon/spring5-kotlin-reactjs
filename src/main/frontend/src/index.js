import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
import { createStore } from 'redux';

import App from './components/App';
import Contact from './components/Contact/Contact';
import reducers from './reducers';

const store = createStore(reducers);

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <div>
        <ul>
          <li>
            <Link to="/">App</Link>
          </li>
          <li>
            <Link to="/contact">Contact</Link>
          </li>
        </ul>

        <Switch>
          <Route exact path = "/" component = {App} />
          <Route exact path = "/contact" component = {Contact} />
        </Switch>
      </div>
    </Router>
  </Provider>,
  document.getElementById('app')
);

