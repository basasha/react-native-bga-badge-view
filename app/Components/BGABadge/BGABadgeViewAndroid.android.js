'use strict';

import React, {
  Component,
  View,
  requireNativeComponent,
  PropTypes
} from 'react-native';

class BGABadgeViewAndroid extends Component {
  constructor(props) {
    super(props);
  }

  _onDismiss() {
    if (this.props.onDismiss) {
      this.props.onDismiss();
    }
  }
  render() {
    return <AndroidBGABadgeView {...this.props} onDismiss={this._onDismiss.bind(this)} />;
  }
}

BGABadgeViewAndroid.propTypes = {
  ...View.propTypes,
  textBadge: PropTypes.string,
  badgeBgColor: PropTypes.string,
  badgeTextColor: PropTypes.string,
  circlePointBadge: PropTypes.bool,
  dragable: PropTypes.bool,
  onDismiss: PropTypes.func,
  badgeTextSizeSp: PropTypes.number,
  badgePaddingDp: PropTypes.number,
};

var AndroidBGABadgeView = requireNativeComponent(`AndroidBGABadgeView`, BGABadgeViewAndroid);

export { BGABadgeViewAndroid as default };
