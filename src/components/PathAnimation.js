/* eslint-disable prettier/prettier */
import PropTypes from 'prop-types';
import { requireNativeComponent } from 'react-native';

var viewProps = {
    name: 'PathAnimationViewManager',
    propTypes: {
        radius: PropTypes.number,
        sides: PropTypes.number,
        lineThickness: PropTypes.number
    }
}

module.exports = requireNativeComponent('PathAnimationViewManager', viewProps);