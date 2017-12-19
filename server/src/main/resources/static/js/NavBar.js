class NavBar extends React.Component {
    constructor (props) {
        super(props);
    }

  render() {
    var menuOptions = [];
    for (let i=0; i < this.props.items.length; i++) {
       menuOptions.push(this.menuElement(i, this.props.items[i].nav, this.props.items[i].display))
    };

    return (
      React.createElement('div', {className: 'navBar'},
        React.createElement('div', {className: 'navBar'},
          React.createElement('ul', {className: 'navBar'},
                menuOptions
            )
        )
      )
    )
  }

  menuElement(itemKey, nav, display) {
      return React.createElement('li', {key : itemKey, className: 'navBar'},
                 React.createElement('a', {onClick : nav}, display)
             );
  }
}
