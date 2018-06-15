import { Map } from 'immutable';
import { handleActions } from 'redux-actions';
import { FETCH_LIST, HANDLE_FORM_VALUE } from '../actions/contact';

const initialState = Map({
  data: [],
  form: Map({
    name: '',
    form: ''
  })
});

export default handleActions({
  [FETCH_LIST]: (state, { payload }) => state
    .set('data', payload),
  [HANDLE_FORM_VALUE]: (state, { payload }) => state
    .setIn(['form', payload.key], payload.value)
}, initialState);
