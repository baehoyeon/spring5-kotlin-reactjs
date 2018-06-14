import {Map} from 'immutable';
import {handleActions} from 'redux-actions';
import {
  FETCH_LIST
} from '../actions/contact';

const initialState = Map({
  data: []
});

export default handleActions({
  [FETCH_LIST]: (state, { payload }) => state
    .set('data', payload)
}, initialState);
