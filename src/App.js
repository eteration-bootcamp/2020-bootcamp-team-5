import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';

import WelcomePage from './containers/WelcomePage';
import NotesPage from './containers/NotesPage';
import AddNewNotePage from './containers/AddNewNotePage';

const store = createStore(
  reducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

const App = () => {
  return (
        <Router>
          <Switch>
            <Route exact path="/" component={WelcomePage} />
            <Route exact path="/notes" component={NotesPage} />
          </Switch>
        </Router>
  );
};


export default App;

const wrapper = document.getElementById("app");
wrapper ? ReactDOM.render(<Provider store={store}><App /></Provider>, wrapper) : false;