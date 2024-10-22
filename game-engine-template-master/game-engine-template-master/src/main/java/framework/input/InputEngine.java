package framework.input;

import java.util.Vector;

import framework.input.source.ISource;

public class InputEngine implements I_InputEngine{
	private final Vector<ISource> sources;

	public InputEngine() {
		this.sources = new Vector<>();
	}

	@Override
	public ISource addSource(ISource source) {
		sources.add(source);
		return source;
	}

	@Override
	public void removeSource(ISource source) {
		for (ISource s : sources) {
			if (s.getId() == source.getId()) {
				sources.remove(s);
				break;
			}
		}
	}

	@Override
	public void update() {
		for (ISource source : sources) {
			source.update();
		}
	}

}
