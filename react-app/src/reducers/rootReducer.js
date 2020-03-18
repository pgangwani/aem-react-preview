import { combineReducers } from 'redux';
import { device } from './homepageReducer';

const staticReducers = {
    api: (state = {}) => state,
    featureflags: (state = {}) => state,
    site: (state = '') => state,
    channel: (state = '') => state,
    env: (state = '') => state,
    assetPath: (state = '') => state,
    homePageContentData: (state = []) => state,
    device,
    disableSW: (state = '') => state
};

const createReducer = (asyncReducers) => combineReducers({
    ...staticReducers,
    ...asyncReducers
});

export default createReducer;
