import { createAction } from 'redux-actions';
import http from '../utils/http';

export const FETCH_LIST = '[CONTACT]FETCH_LIST';
export const HANDLE_FORM_VALUE = '[CONTACT]HANDLE_FORM_VALUE';

export const fetchList = (dispatch) => http.get('/users')
  .then((response) => dispatch(createAction(FETCH_LIST)(response.data)));

export const handleFormValue = (dispatch, key, value) => {
  dispatch(createAction(HANDLE_FORM_VALUE)({ key, value }));
};

export const addUser = (dispatch, form) => {
  form.name && form.phone && http.post('/users', form)
    .then(() => http.get('/users')
      .then((response) => {
        dispatch(createAction(FETCH_LIST)(response.data));
        dispatch(createAction(HANDLE_FORM_VALUE)({ key: 'name', value: '' }));
        dispatch(createAction(HANDLE_FORM_VALUE)({ key: 'phone', value: '' }));
      }));
};
