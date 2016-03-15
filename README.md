:running:BGABadgeView-Android桥接React Native案例:running:
============

[BGABadgeView-Android](https://github.com/bingoogolapple/BGABadgeView-Android)

### 效果图
![Image of RecyclerViewDemo](https://raw.githubusercontent.com/bingoogolapple/react-native-bga-badge-view/master/screenshots/demo1.gif)

```
import BGABadgeViewAndroid from './app/Components/BGABadge/BGABadgeViewAndroid';
import DemoItem from './app/Components/demo/DemoItem';

class BGABadgeViewRN extends Component {

  constructor(props) {
    super(props);
    this.state = {
      badgeText: "20",
    };
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={{paddingBottom: 30, fontSize: 22, color: '#50a3fc'}}>React Native - BGABadgeView</Text>

        <DemoItem title="显示第一个徽章" handleClick={this.showFistBadge.bind(this)} />
        <DemoItem title="隐藏第一个徽章" handleClick={this.hiddenFistBadge.bind(this)} />
        <BGABadgeViewAndroid dragable={false} textBadge={this.state.badgeText} style={styles.badge} onDismiss={() => this.onDismiss("第1个")} />

        <BGABadgeViewAndroid badgeBgColor="#00ff00" badgeTextColor="#ff0000" badgePaddingDp={10} badgeTextSizeSp={14} textBadge="9" style={styles.badge} onDismiss={() => this.onDismiss("第2个")} />

        <BGABadgeViewAndroid textBadge="99" style={styles.badge} onDismiss={() => this.onDismiss("第3个")} />

        <BGABadgeViewAndroid circlePointBadge={true} badgePaddingDp={6} style={styles.badge} onDismiss={() => this.onDismiss("第4个")} />

        <Image source={{uri: 'https://avatars2.githubusercontent.com/u/8949716'}}
       style={styles.backgroundImage} resizeMode={Image.resizeMode.contain} >
        <BGABadgeViewAndroid drawableBadge="avatar_vip" style={{
          width: 30,
          height: 20,
        }} onDismiss={() => this.onDismiss("第5个")} />
        </Image>
      </View>
    );
  }

  onDismiss(tip) {
    ToastAndroid.show('消失 ' + tip, ToastAndroid.SHORT)
  }

  hiddenFistBadge() {
    this.setState({
          badgeText: ""
        });
  }

  showFistBadge() {
    this.setState({
          badgeText: "20"
        });
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  badge: {
    width: 60,
    height: 60,
  },
  backgroundImage: {
    flexDirection: 'row',
    justifyContent: 'flex-end',
    flex: 1,
    width: 100,
    height: 100,
  }
});
```

### 关于我

| 新浪微博 | 个人主页 | 邮箱 | BGA系列开源库QQ群 |
| ------------ | ------------- | ------------ | ------------ |
| <a href="http://weibo.com/bingoogol" target="_blank">bingoogolapple</a> | <a  href="http://www.bingoogolapple.cn" target="_blank">bingoogolapple.cn</a>  | <a href="mailto:bingoogolapple@gmail.com" target="_blank">bingoogolapple@gmail.com</a> | ![BGA_CODE_CLUB](http://7xk9dj.com1.z0.glb.clouddn.com/BGA_CODE_CLUB.png?imageView2/2/w/200) |

## License

    Copyright 2016 bingoogolapple

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
