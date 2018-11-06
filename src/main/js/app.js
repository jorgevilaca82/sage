const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {unidadesDeEnsino: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/unidades-de-ensino'}).done(response => {
			this.setState({unidadesDeEnsino: response.entity._embedded.unidadesDeEnsino});
		});
	}

	render() {
		return (
			<UnidadedesDeEnsinoList unidadesDeEnsino={this.state.unidadesDeEnsino}/>
		)
	}
}

class UnidadedesDeEnsinoList extends React.Component {
	render() {
		const unidadesDeEnsino = this.props.unidadesDeEnsino.map(unidade =>
			<UnidadeDeEnsino key={unidade._links.self.href} unidadeDeEnsino={unidade}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{unidadesDeEnsino}
				</tbody>
			</table>
		)
	}
}

class UnidadeDeEnsino extends React.Component {
	render() {
		return (
			<tr>
				<td>{this.props.unidadeDeEnsino.nomeFantasia}</td>
				<td>{this.props.unidadeDeEnsino.cnpj}</td>
				<td>{this.props.unidadeDeEnsino.tipo}</td>
			</tr>
		)
	}
}

ReactDOM.render(<App />, document.getElementById('react'))