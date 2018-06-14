import { createAction } from 'redux-actions';
import http from '../utils/http';

export const FETCH_LIST = '[CONTACT]FETCH_LIST';

export const fetchList = (dispatch) => http.get('/users')
    .then((response) => dispatch(createAction(FETCH_LIST)(response.data)));
