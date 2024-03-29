package chiptools.jprobe.function.probefilter;

import java.util.List;

import jprobe.services.function.Function;
import util.genome.probe.Probe;
import util.genome.probe.ProbeUtils.Filter;
import chiptools.jprobe.function.SequencesArg;

public class IncludeSubseqArgument extends SequencesArg<ProbeFilterParam>{

	public IncludeSubseqArgument(Function<?> parent, boolean optional) {
		super(parent.getClass(), IncludeSubseqArgument.class, optional);
	}

	@Override
	protected void process(ProbeFilterParam params, final List<String> seqs, String fileName) {
		params.setIncludedSeqs(fileName);
		params.addFilter(new Filter(){

			@Override
			public boolean keep(Probe p) {
				for(String s : seqs){
					if(p.getSequence().contains(s)) return true;
				}
				return false;
			}
			
		});
	}

}
