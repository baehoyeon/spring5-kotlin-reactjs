"use strict";

import React from 'react';
import ReactDOM from 'react-dom';

import { MessageBox } from './components/MessageBox.js';

window.app = ReactDOM.render(<MessageBox />, document.getElementById('content'));
